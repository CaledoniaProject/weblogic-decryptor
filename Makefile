JARS=jars/weblogic.server.merged.jar:jars/com.bea.core.weblogic.security.t3.standalone.client_2.2.0.0.jar:jars/cryptoj.jar:jars/wlthint3client.jar

default:
	javac -cp $(JARS) Decode.java

run: default
	java -cp .:$(JARS) Decode

clean:
	rm -f *.o $(TARGET)

