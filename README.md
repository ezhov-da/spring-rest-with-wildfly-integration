# spring-rest-with-wildfly-integration

Тестовый проект направленный на изучение возможности интеграции SPRING-REST с очередью сообщений настроенной на сервере приложений WildFly.

Для работы приложения необходима настроенная очередь на сервере с названием **testQueue**.

После деплоя на сервер этого **.war** файла доступна ссылка для тестирования:

[http://localhost:8080/spring-rest-with-wildfly-integration-0.0.1-SNAPSHOT/greeting?name=Test](http://localhost:8080/spring-rest-with-wildfly-integration-0.0.1-SNAPSHOT/greeting?name=Test)

Основной момент, который необходим для понимания:  
На сервере в контексте уже существует **javax.jms.ConnectionFactory**, её необходимо просто установить через _@Autowired_ для создания **JmsTemplate**.