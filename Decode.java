import java.io.*;
import java.util.*;
import weblogic.security.internal.SerializedSystemIni;
import weblogic.security.internal.encryption.ClearOrEncryptedService;
import weblogic.security.internal.encryption.EncryptionService;

public class Decode {

    public static HashMap<String, String> parseBootProperties (String fileName)
    {
        HashMap<String, String> pair = new HashMap<String, String> ();

        try {
            String line;
            BufferedReader br = new BufferedReader (new FileReader (fileName));

            while (null != (line = br.readLine()))
            {
                int pos = line.indexOf ("{");

                if (pos != -1)
                {
                    pair.put (line.substring (0, pos - 1), line.substring (pos));
                }
            }

            br.close ();
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return pair;
    }

    public static void main (String[] args)
    {
        try {
            File serializedSystemIni    = new File ("data");
            HashMap<String, String> map = parseBootProperties ("data/boot.properties");

            EncryptionService encryptionService = SerializedSystemIni.getEncryptionService (serializedSystemIni.getAbsolutePath());
            ClearOrEncryptedService ces         = new ClearOrEncryptedService (encryptionService);

            for (Map.Entry<String, String> entry : map.entrySet())
            {
                System.out.println (entry.getKey() + ": " + ces.decrypt (entry.getValue()));
            }
        }
        catch (Exception e )
        {
            e.printStackTrace();
        }
    }
}

