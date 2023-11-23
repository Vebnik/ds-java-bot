Write-Host "Try to build"
mvn clean compile assembly:single

Write-Host "Try to start"
java -cp D:\new-project\java\bots\ds-music-bot\ds-bot\target\ds-bot-1.0-jar-with-dependencies.jar com.lava.bot.App