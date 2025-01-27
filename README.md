## JCIFS File Upload Project

This project demonstrates how to upload files to a Windows shared folder using the JCIFS library in Java. 
JCIFS is a Java library that implements the CIFS/SMB networking protocol, allowing you to access shared files and directories on Windows servers.

#### Prerequisites
-Java Development Kit (JDK) 8 or later
-Maven (for dependency management)
-Access to a Windows shared folder with the necessary permissions

#### Setup
Clone the Repository:

```bash
git clone https://github.com/bruce-mig/jcifs-file-transfer.git
cd jcifs-file-upload
```

#### Add JCIFS Dependency:
Ensure that the pom.xml file includes the JCIFS dependency:

```xml
<dependency>
    <groupId>jcifs</groupId>
    <artifactId>jcifs</artifactId>
    <version>1.3.19</version>
</dependency>
```
#### Configure Access Credentials:

Update the JCIFSExample.java file with your domain, username, password, and shared folder path:

```java
String domain = "your_domain"; // e.g., "mydomain"
String username = "your_username"; // e.g., "myuser"
String password = "your_password"; // e.g., "mypassword"
String sharedFolderPath = "smb://192.168.1.250/shared_folder/"; // Path to the shared folder
String localFilePath = "/path/to/local/file.txt"; // Path to the local file to be uploaded
```

#### Usage

Compile the Project:

```bash
mvn compile
```

#### Run the App:

```bash
mvn spring-boot:run
```

