
- before getting started
  - create github account

## create Google Computing Platform account
- go to https://cloud.google.com/
- click "TRY IT FREE"
- create account

## set budget
- Billing & alerts
  -  Create BUDGET
 <img src="https://i.gyazo.com/cfb95da3a13ae2993e6f033de7a3f17b.png" width="320px"/>

## Create GCP PROJECT
Following instructions are same as [this page](https://cloud.google.com/compute/docs/quickstart-linux)
- click [▽] in top of bar <img src="https://i.gyazo.com/f3ed63049158433f9bb037d0b283dcb6.png"  />
- click [+] <img src="https://i.gyazo.com/594d23f0b5c29fc780568a6a711c9ccb.png"  />
- input project name (ex. interview-gami)
- click [create]
- wait a moment (would take a few minute)
- select your project in top of bar


## Create Instance
- Select Menu (〓) , then Compute Engine
- wait a second
- select VM instances
- Create an instance
  - Fill in like this <img src="https://i.gyazo.com/6c9e6d857cad9cd4e0e6cd7c4dbf1f4e.png" />
  - select micro in Machine type <- if select other type, you have to pay some money
    - <img src="https://i.gyazo.com/6935c7f9aa8d105de28cb62df3a842d7.png" />
    - like right part micro is free
  - select ubuntu 16.04
  - select Allow HTTP  in  Firewall
- click [create]
- wait a second

## Access instance 
- click your instance in "VM instances" view to goto "VM instance detail"
- Click [SSH] near Remote access

## in ssh console
- type following commands

```
sudo apt-get update
sudo apt install -y openjdk-8-jdk maven
git clone https://github.com/iwag/java-jersey-restful-server-client-sample.git
cd java-jersey-restful-server-client-sample
git checkout finalproject
cd projserver
mvn clean package
mvn jetty:run
sudo java -jar target/dependency/jetty-runner.jar —port 80 target/*.war
```

- VM instances -> your instance ->  Click "External IP (10…)"
  - <img src="https://i.gyazo.com/d77f8f20c469d9a4ff5d1a5fe9f4cef0.png" />
  - http://{PASTE EXTERNAL_IP}/interview/Java

## finish
- Go to VM instances and select your instance then click [DELETE]


# how to apply
