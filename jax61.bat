C:\Program1\Java\JDKs\Sun\bin\java -cp .;C:\Program1\Java\JDKs\Sun\jre\lib\rt.jar;C:\Incoming\Java\IBM\JAX\jax61.zip;C:\Documents\Java\APLIKASIRUNLENGTHENCODING -DJAVAHOME=C:\Program1\Java\JDKs\Sun com.ibm.jax.Batch RLEFrEnd.jax

copy RLEFrEnd.zip jax\RLEFrEnd.zip

del RLEFrEnd.zip
cd jax
del *.class

C:\Program1\Java\JDKs\Sun\bin\jar xf RLEFrEnd.zip
C:\Program1\Java\JDKs\Sun\bin\jar cmf Manifest.mf RLEFrEnd.jar *.class
copy RLEFrEnd.jar ..\APLIKASIRUNLENGTHENCODING.jar

cd ..
