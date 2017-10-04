chcp 1252
java -jar -Dwebdriver.chrome.driver="C:\dev\eclipse-workspace\extranet-saw\tools\chromedriver.exe" selenium-server-standalone-3.5.3.jar -role node -hub http://10.2.1.32:4444/grid/register -browser "browserName=chrome,maxInstances=2,maxSession=2,platform=WINDOWS" -sessionTimeout 60 -browserTimeout 60
pause

