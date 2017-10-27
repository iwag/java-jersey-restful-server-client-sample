## clone repository in local
- click "Fork" in https://github.com/iwag/java-jersey-restful-server-client-sample
- open terminal
- git clone git@github.com:!!!YOUR_NAME!!!/java-jersey-restful-server-client-sample.git
  - OR git clone https://github.com/YOUR_NAME/java-jersey-restful-server-client-sample.git
- install maven https://maven.apache.org/install.html
  - https://brew.sh/ can be helpful to install
- cd java-jersey-restful-server-client-sample
- mvn package
- java -jar target/dependency/jetty-runner.jar target/*.war
- open http://localhost:8080/interview/Java


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


## Create an Instance
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
sudo java -jar target/dependency/jetty-runner.jar —port 80 target/*.war
```

- VM instances -> your instance ->  Click "External IP (10…)"
  - <img src="https://i.gyazo.com/ddf640b9ef2ae4eb2392d1b3e00db7fb.png" />
  - open http://{PASTE EXTERNAL_IP}/interview/Java

## finish
- Go to VM instances and select your instance then click [DELETE]

# how to apply (1)

- download my repository in your computer, [download](https://github.com/iwag/java-jersey-restful-server-client-sample/archive/finalproject.zip)
- replace all resource and models package with yours
- create github repository
- git init && git push
- Do same thing above instructions


# how to apply (2)

copy [main](https://github.com/iwag/java-jersey-restful-server-client-sample/blob/master/projserver/src/main/java/io/github/iwag/jerseystarter/main/Main.java) instead main function.

add this into dependencies in pom.xml

```
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

add this into plugin in pom.xml

```
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
```
