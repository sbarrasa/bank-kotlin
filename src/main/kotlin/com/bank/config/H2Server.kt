package com.bank.config

import org.h2.tools.Server

object H2Server {
   fun startTcpServer() = Server.createTcpServer(
      "-tcp",
      "-tcpAllowOthers",
      "-tcpPort",
      "9092"
   ).start()

   fun startWebServer() = Server.createWebServer(
      "-web",
      "-webAllowOthers",
      "-webPort",
      "8082"
   ).start()
}
