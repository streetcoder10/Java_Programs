#include <SPI.h>
#include <Ethernet.h>
#include <IPStack.h>
#include <Countdown.h>
#include <MQTTClient.h>
#include <dht11.h>
#include <Servo.h>
#define MS_PROXY "quickstart.messaging.internetofthings.ibmcloud.com"
#define MQTT_PORT 1883
#define MQTT_MAX_PACKET_SIZE 256
byte mac[] = { 0x90, 0xA2, 0xDA, 0x0E, 0xCC, 0x51 };
#define MQTT_CLIENTID "d:quickstart:iotsample-arduino:90a2da0ecc51"
#define MQTT_TOPIC "iot-2/evt/status/fmt/json"
#define pingPin 7 
#define trigPin 8        
#define BOUNDARY 20      
#define INTERVAL 25 
EthernetClient c; 
IPStack ipstack(c);
MQTT::Client<IPStack, Countdown, 100, 1> client = MQTT::Client<IPStack, Countdown, 100, 1>(ipstack);
String deviceEvent;
int pos = 0;
int motorPin1 = 13; 
int motorPin2 = 12; 
int motorPin3 = 10;
int motorPin4 = 11;
int state;
int enablePin;
int flag=0; 
dht11 DHT11;
Servo myservo;

void setup() 
{
DHT11.attach(3);
pinMode(motorPin1, OUTPUT);
pinMode(motorPin2, OUTPUT);
pinMode(motorPin3, OUTPUT);
pinMode(motorPin4, OUTPUT);
pinMode(trigPin,OUTPUT);
pinMode(pingPin,INPUT);

digitalWrite(enablePin, HIGH);

Serial.begin(9600);
Ethernet.begin(mac);
}

void loop() 
{
int rc = -1;
if (!client.isConnected()) 
{
Serial.println("Connecting to IoT Foundation for publishing Temperature");
while (rc != 0) 
{
rc = ipstack.connect(( (char *) MS_PROXY), MQTT_PORT);
}
MQTTPacket_connectData data = MQTTPacket_connectData_initializer;
data.MQTTVersion = 3;
data.clientID.cstring = (char *)MQTT_CLIENTID;    
rc = -1;
while ((rc = client.connect(data)) != 0);
Serial.println("Connected successfully\n");
Serial.println("Temperature(in C)\tDevice Event (JSON)\t Ping Distance (in cm) ");
Serial.println("____________________________________________________________________________");
}
MQTT::Message message;
message.qos = MQTT::QOS0;
message.retained = false;
deviceEvent = String("{\"d\":{\"myName\":\"Arduino Uno\",\"temperature\":");
char buffer[60];
dtostrf(getTemp(),1,2, buffer);
dtostrf(readDistance(),1,2, buffer);
deviceEvent += buffer;
deviceEvent += "}}";
Serial.print("\t");
Serial.print(buffer);
Serial.print("\t\t");
deviceEvent.toCharArray(buffer, 60);
Serial.println(buffer);
message.payload = buffer;
message.payloadlen = strlen(buffer);
rc = client.publish(MQTT_TOPIC, message);

if (rc != 0) 
{
Serial.print("return code from publish was ");
Serial.println(rc);
}
client.yield(1000);
if(Serial.available() >= 0)
{     
state = Serial.read();   
flag=0;
}    
if (state == '1') 
{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW);

{
digitalWrite(motorPin4, HIGH); 
if(flag == 0)
{
Serial.println("Turning Left!!");
flag=1;
}
}     
}
else if (state == '2') 
{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW);

{
digitalWrite(motorPin3, HIGH); 
if(flag == 0)
{
Serial.println("Turning Right!");
flag=1;
}
}     
}
else if (state == '3') 
{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW);

{
digitalWrite(motorPin2, HIGH); 
if(flag == 0)
{
Serial.println("Tracking Back!");
flag=1;
}
}     
}
else if (state == '4') 
{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW);

{
digitalWrite(motorPin1, HIGH); 
if(flag == 0)
{
Serial.println("Moving Forward!");
flag=1;
}
}     
}
else if (state == '5') 
{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW);

{
digitalWrite(motorPin1, LOW); 
digitalWrite(motorPin2, LOW); 
digitalWrite(motorPin3, LOW); 
digitalWrite(motorPin4, LOW); 
if(flag == 0)
{
Serial.println("Stopped!!");
flag=1;
}
}     
}
else if (state == '0')
{ 
Serial.println("Self Driving Mode!!");   
long distance;        
ust:
do 
{
forward();
distance = readDistance();      
Serial.println(distance);       
delay(INTERVAL);                
}
while(distance >= BOUNDARY);      
backward();                       
delay(0);               
rightTurn(500); 
delay(0);
goto ust;
}
}
void forward()
{
digitalWrite(13, HIGH);   
delay(100);   
}  
void backward()
{
digitalWrite(13,LOW);
delay(100);
digitalWrite(12, HIGH);  
delay(500);  
digitalWrite(12, LOW);  
delay(500);    
}
void rightTurn(int duration)
{
digitalWrite(10, HIGH);  
delay(750); 
digitalWrite(10, LOW);  
delay(750);  
delay(duration);                  
}
void leftTurn(int duration)
{
digitalWrite(11, HIGH);  
delay(750); 
digitalWrite(11, LOW);  
delay(750);  
delay(duration);                  
}

double getTemp(void) 
{
int chk = DHT11.read();

Serial.print("Read sensor: ");
switch (chk)
{
case 0: Serial.println("OK"); break;
case -1: Serial.println("Checksum error"); break;
case -2: Serial.println("Time out error"); break;
default: Serial.println("Unknown error"); break;
}
Serial.print("Temperature (°C): ");
Serial.println((float)DHT11.temperature, DEC);
Serial.print("Humidity (%): ");
Serial.println((float)DHT11.humidity, DEC);
delay(1000);
}
float readDistance()
{
long duration, inches, cm;
digitalWrite(trigPin,LOW);
delayMicroseconds(2); 
digitalWrite(trigPin,HIGH); 
delayMicroseconds(5);
digitalWrite(trigPin,LOW);
pinMode(pingPin, OUTPUT);
digitalWrite(pingPin, LOW);
delayMicroseconds(2);
digitalWrite(pingPin, HIGH);
delayMicroseconds(5);
digitalWrite(pingPin, LOW);
pinMode(pingPin, INPUT);
duration = pulseIn(pingPin, HIGH);

cm = microsecondsToCentimeters(duration);
return(cm);
}
long microsecondsToCentimeters(long microseconds)
{
return microseconds / 29 / 2;
}
