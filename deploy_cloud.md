# how to apply your application 
- get back to your working directory.
- add these snipets into your pom.xml
  ```xml

		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-dependency-plugin</artifactId>
			<version>2.3</version>
			<executions>
				<execution>
					<phase>package</phase>
					<goals><goal>copy</goal></goals>
					<configuration>
						<artifactItems>
							<artifactItem>
								<groupId>org.eclipse.jetty</groupId>
								<artifactId>jetty-runner</artifactId>
				        <version>9.3.8.v20160314</version>
								<destFileName>jetty-runner.jar</destFileName>
							</artifactItem>
						</artifactItems>
					</configuration>
				</execution>
			</executions>
		</plugin>
		<plugin>
			<groupId>org.eclipse.jetty</groupId>
			<artifactId>jetty-maven-plugin</artifactId>
			<version>9.3.8.v20160314</version>
		</plugin>
  ```
  
  ```xml
   <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-servlet</artifactId>
      <version>9.3.8.v20160314</version>
    </dependency>
    <dependency>
      <groupId>org.eclipse.jetty</groupId>
      <artifactId>jetty-webapp</artifactId>
      <version>9.3.8.v20160314</version>
    </dependency>
   ```
- mvn package and run as `java -jar target/dependency/jetty-runner.jar target/*.war` 
- if successful in local, commit github
- git commit 
- git push origin deploytogoogle


## create Google Computing Platform account
- go to https://cloud.google.com/
- click "TRY IT FREE"
- create account

## Create GCP PROJECT
Following instructions are same as [this page](https://cloud.google.com/compute/docs/quickstart-linux)
- open GCP console https://console.cloud.google.com
- click [▽] in top of bar <img src="https://i.gyazo.com/f3ed63049158433f9bb037d0b283dcb6.png"  />
- click [+] <img src="https://i.gyazo.com/594d23f0b5c29fc780568a6a711c9ccb.png"  />
- input project name (ex. interview-gami)
- click [create]
- wait a second (would take a few seconds)
- select your project in top of bar

## set budget
- select Menu (〓) , then Billing & alerts
  -  Create BUDGET
  - set ammount of money like this
 <img src="https://i.gyazo.com/cfb95da3a13ae2993e6f033de7a3f17b.png" width="320px"/>

## Create an Instance
- Select Menu (〓) , then click Compute Engine
- wait a second
- select VM instances
- Create an instance
  - Fill in like this <img src="https://i.gyazo.com/6c9e6d857cad9cd4e0e6cd7c4dbf1f4e.png" />
  - select micro in Machine type <- if select other type, you have to pay some money
    - <img src="https://i.gyazo.com/6935c7f9aa8d105de28cb62df3a842d7.png" />
    - micro is free as you can see
  - select ubuntu 16.04
  - select Allow HTTP  in  Firewall
  - paste your id_rsa.pub SSH keys and add item <img src="https://i.gyazo.com/46ae1a4856a4f8b11a38e05561e83422.png" />
- click [create]
- wait a second

## Access instance 
- click your instance in "VM instances" view to goto "VM instance detail"
- Remember external IP <img src="https://i.gyazo.com/ddf640b9ef2ae4eb2392d1b3e00db7fb.png" />
- open terminal
  - `ssh YOUR_EXTERNAL IP`

## setup machine and run server
- type following commands

```
sudo apt-get update
sudo apt install -y openjdk-8-jdk maven
git clone https://github.com/YOUR_NAME/YOUR_REPOSITORY
cd YOUR_REPOSITORY
git checkout deploytogoogle
mvn package
sudo java -jar target/dependency/jetty-runner.jar  -—port 80  target/*.war
```

- VM instances -> your instance ->  Click "External IP (10…)"
  - open http://{PASTE EXTERNAL_IP}/interview/Java

## set up dynamic DNS on your instance

- create an account https://www.noip.com/sign-up
- log in https://my.noip.com/#!/
- add quick dns <img src="https://i.gyazo.com/25909a386ec323f763600a024a839932.png" />
  - input myhost
  - add hostname
- click Dynamic DNS [Free] in a left pane
- click your created dns
- input your external IP of the instance onto IPv4 Address
- open YOUR_DDNS.ddns.com/interview/Java
  - it can take a few minutes to update 

## terminate
- Go to VM instances and select your instance then click [DELETE]

## Run sample application locally
- click "Fork" in https://github.com/iwag/java-jersey-restful-server-client-sample
- open terminal
- git clone git@github.com:!!!YOUR_NAME!!!/java-jersey-restful-server-client-sample.git
  - OR git clone https://github.com/YOUR_NAME/java-jersey-restful-server-client-sample.git
- install maven https://maven.apache.org/install.html
  - https://brew.sh/ can be helpful to install
  - `brew install maven` if you have brew
- cd java-jersey-restful-server-client-sample
- mvn package
- java -jar target/dependency/jetty-runner.jar target/*.war
- open http://localhost:8080/interview/Java
  - I don't use _tomcat_ for several reasons like confusing setup. I think jetty is much easier way to run servlet container


