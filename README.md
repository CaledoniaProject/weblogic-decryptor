How to use that?
----------------

Put `boot.properties` into data/ and `SerializedSystemIni.dat` into data/security/

Cross-domain decryption will not work.


Decryption
----------

Once the two files mentioned above is in place, simply run `make run`:

<pre>
%> make run
username: weblogic
password: z20059864y
</pre>

There you go!


Notes from Author
-----------------

Tested against AES / 3DES algorithm, works. The jars in this repository are copied from latest weblogic distribution (version string `wls12130`)

