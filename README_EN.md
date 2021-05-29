#Minecraft Custom Pack Downloader<br>
###### [Chinese](README.md)<br>
##What this Program?<br>
This is a download Minecraft texture pack program.<br>
##Based on what development?<br>
Only Java(~~Maybe use C++?~~)<br>
##Future<br>
**note:delete line are completed functions**
1. ~~Download texture packs~~
2. ~~Online update texture packs info~~
3. ~~Add Gui~~
4. ~~Write Crash info~~
5. ~~Open resource code~~
6. ~~BASE64 encodes sever download url and email.~~(After encoding and decoding,there will be strange characters the beginning.)
7. aria2 multithreading download
##怎么使用这个软件?
1. In download server,add"list.txt","update_info.txt"and"empty"file
    - list.txt格式:"a.zip;b.zip"
    - update_info.txt格式:"date:update xxx;date:update xxx"
    - empty文件:新建一个文本文档,不要后缀,rename is empty;
2. 在启动bat的-jar前面加上' -DCreate_Info="Yes" '，会打开配置Gui。
3. 打开Gui后输入服务器URL地址以及你的邮箱，点击OK。
4. 压缩文件。
    - 需压缩下载器本体，启动bat以及config.cfg。
5. 发送给服务器玩家。 