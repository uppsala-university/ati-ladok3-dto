# Ladok 3 Java Data Transfer Objects

Java värdeobjekt (Data Transfer Objects - DTO) för Ladok 3 finns i denna
produkt. DTO:er för marshalling/unmarshalling genereras från Ladok 3:s XSD:er. 

## Versionshistorik

Från och med version 2.52.4 kräver denna produkt minst Java 8.

Från och med version 3.0.0 är denna produkt inte längre paketerad som en
OSGi-bundle, utan som en normal jar.

Från och med version 3.0.0 är klassen DateAdapter borttagen.

Från och med version 3.0.0 kräver denna produkt minst Java 17 och JAXB 4.

## Lägga till som ett beroende

För att använda denna produkt som ett beroende i ett Maven-bygge behöver du
lägga till den som en dependency i ditt eget projekts ```pom.xml```

```
  <dependencies>
    <dependency>
      <groupId>se.sunet.ati.ladok</groupId>
      <artifactId>ati-ladok3-dto</artifactId>
      <version>1.0.0-SNAPSHOT</version>
    </dependency>
    ...
  </dependencies>
```

## Policy för versionsnummer 

Denna produkt använder versionsnummer som motsvarar den version av Ladok3 vars
XSD:er projektet använder.

### Använda releaser

Om du vill använda en release av denna produkt behöver du inte lägga till något
speciellt repository, då alla releaser publiceras i Maven Central Repository.

### Använda SNAPSHOTs

Om du vill använda en SNAPSHOT-version av denna produkt så behöver du lägga till
en konfiguration för detta. SHAPSHOTs publiceras till Maven Central Portal. För Maven är det
enklast att lägga till en profil i ```settings.xml``` som ser ut så här:

```
    <!-- For projects requiring SNAPSHOTs from Maven Central Portal  -->
    <profile>
      <id>central-portal-snapshots</id>
      <repositories>
        <repository>
          <name>Central Portal Snapshots</name>
          <id>central-portal-snapshots</id>
          <url>https://central.sonatype.com/repository/maven-snapshots/</url>
          <releases>
            <enabled>false</enabled>
          </releases>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
```

När du sedan bygger din egen produkt med Maven så behöver du aktivera profilen:

    mvn clean verify -Pcentral-portal-snapshots

## Att göra en release
Man kan göra en release via Jenkins eller via sin egen dator (som i så fall behöver inställningar i ```settings.xml```, ```toolchains.xml``` samt ha stöd för gpg)

### Jenkins
Gå till  projektet ```ati-ladok3-dto``` och kör ```Perform Maven Release```, ange versionsnummer för den release som ska göras och 
den snapshot-versionen som ska användas efter att release är gjord (inga inloggningsuppgifter behöver anges)

### Lokalt via egen dator
För att göra en release behöver du lägga till nedanstående inställningar i din ```settings.xml```.

```
    <server>
      <id>github</id>
      <username>ditt-github-användarnamn</username>
      <password>ditt-github-lösenord</password>
    </server>
    <server>
      <id>central</id>
      <username>ATI:s användarnamn hos Maven Central Portal</username>
      <password>Tillhörande lösenord</password>
    </server>
    ...
    <profile>
      <id>ati-release</id>
      <properties>
        <gpg.passphrase>Din GPG passphrase</gpg.passphrase>
      </properties>
    </profile>
```

För att göra releasen använder du dig av Maven Release Plugin:

    mvn clean verify
    mvn release:prepare
    mvn release:perform

## Publicera releasen via Maven Central Portal

Slutligen behöver du gå till Maven Central Portal för att avsluta jobbet genom att följa
[deras instruktioner](https://central.sonatype.org/publish/publish-portal-guide/).

I korthet gör man så här:
* logga in på [Maven Central Portal](https://central.sonatype.com/publishing/deployments)
* välj vid behov rätt Deployment till vänster
* kontrollera att innehållet under Component Files och Component Coordinates är korrekt
* klicka på ```Publish```
* vänta upp till 30 minuter på att filerna ska dyka upp på [Maven Central](https://repo1.maven.org/maven2/se/sunet/ati/ladok/ati-ladok3-dto/)
