set ICONEDITOR=C:\Anwendungen\IconEditor
set CLASSPATH=%CLASSPATH%;%ICONEDITOR%\lib\IconEditor.jar
set CLASSPATH=%CLASSPATH%;%ICONEDITOR%\lib\image4j.jar
set CLASSPATH=%CLASSPATH%;%ICONEDITOR%\lib\commons-math3-3.6.1.jar
cd %ICONEDITOR%
java -Xmx4096M -Xms128M test.Main

