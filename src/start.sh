ICONEDITOR=/home/christian/IconEditor
CLASSPATH=${CLASSPATH}:${ICONEDITOR}/IconEditor.jar
CLASSPATH=${CLASSPATH}:${ICONEDITOR}/image4j.jar
CLASSPATH=${CLASSPATH}:${ICONEDITOR}/commons-math3-3.6.1.jar
export CLASSPATH
cd ${ICONEDITOR}
java -Xmx4096M -Xms128M test.Main
exit

