# Ladok 3 Java Data Transfer Objects

Java värdeobjekt (Data Transfer Objects - DTO) för Ladok 3 finns i denna
produkt. DTO:er för marshalling/unmarshalling genereras från Ladok 3:s XSD:er. 

## Lägga till som ett beroende

För att använda denna produkt som ett beroende i ett Maven-bygge behöver du
lägga till två saker i ditt eget projekts ```pom.xml```

```
  <dependencies>
    <dependency>
      <groupId>se.sunet.ati.ladok</groupId>
      <artifactId>ati-ladok3-dto</artifactId>
      <version>1.0.0-SNAPSHOT</version>
      <type>bundle</type>
    </dependency>
    ...
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.apache.felix</groupId>
        <artifactId>maven-bundle-plugin</artifactId>
        <version>2.3.7</version>
      </plugin>
      ...
    </plugins>
  </build>
```

Anledningen till att du behöver lägga till ```maven-bundle-plugin``` är att
denna produkt är av typen ```bundle``` (OSGi-bundle), vilket är en typ som
normalt inte stöds av Maven. Detta stöd tillhandahålls istället av ```maven-bundle-plugin```.

### Använda releaser

Om du vill använda en relase av denna produkt behöver du inte lägga till något
speciellt repository, då alla releaser publiceras i Maven Central Repository.

### Använda SNAPSHOTs

Om du vill använda en SNAPSHOT-version av denna produkt så behöver du lägga till
en konfiguration för detta. SHAPSHOTs publiceras i OSSRH. För Maven är det
enklast att lägga till en profil i ```settings.xml``` som ser ut så här:

```
    <!-- For projects requiring SNAPSHOTs from OSSRH -->
    <profile>
      <id>ossrh-snapshots</id>
      <repositories>
        <repository>
          <id>ossrh-snapshots</id>
          <url>https://oss.sonatype.org/content/repositories/snapshots</url>
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

    mvn clean verify -Possrh-snapshots

## Att göra en release

För att göra en release behöver du lägga till nedanstående inställningar i din ```settings.xml```.

```
    <!-- OSSRH -->
    <server>
      <id>ossrh</id>
      <username>ATI:s användarnamn hos OSSRH</username>
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

    mvn clean release:prepare
    mvn release:perform
