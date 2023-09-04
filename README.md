###Сервис проверки скобок

Сервис проверяет входящий JSON запрос типа 
```{"text" : "Тескс для проверки скобок (123)"}``` по адресу 
```localhost:8080/api/checkBrackets``` на правильность скобок

Есть 2 способа развертывания:
1. Запустите главный класс _BracketsCheckerApplication.java_
2. Из каталога ```distr``` запустите скрипт ```buldAndDepDocker.sh```, затем запустите docker-compose командой```docker-compose up -d```