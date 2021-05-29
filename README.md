# Minecraft Custom Pack Downloader<br>
###### [English](README_EN.md)<br>
## 这是什么?<br>
这是一个下载我的世界服务器资源包的软件。<br>
## 基于什么开发?<br>
Java，仅此而已(~~也许会用C++?~~)<br>
## 开发这个是干啥的?<br>
为了让我服的玩家~~亲切的~~体验到各种梗，所以写了这个。<br>
## 功能<br>
**注:删除线为已完成的功能**
1. ~~下载资源包~~
2. ~~实时联网更新资源包信息~~
3. ~~添加Gui~~
4. ~~写出崩溃信息~~
5. ~~开放源代码~~
6. ~~BASE64编码服务器下载地址以及邮箱~~(但编码+解码后开头有奇怪的字符)
7. aria2多线程下载
##怎么使用这个软件?
1. 在提供下载的服务器内添加"list.txt","update_info.txt"和"empty"文件
   - list.txt格式:"a.zip;b.zip"
   - update_info.txt格式:"10月9日:更新了xxx;10月20日:更新了xxx"
   - empty文件:新建一个文本文档，不要后缀，改名为empty;
2. 在启动bat的-jar前面加上' -DCreate_Info="Yes" '，会打开配置Gui。
3. 打开Gui后输入服务器URL地址以及你的邮箱，点击OK。
4. 压缩文件。
    - 需压缩下载器本体，启动bat以及config.cfg。
5. 发送给服务器玩家。    