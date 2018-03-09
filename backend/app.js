var express = require("express");
var app = express();
var sql = require('mssql')

var dbConfig = {
  server: "",
  database:"",
  user: "",
  password:"",
  port: 1443
};



function getUser() {
  var conn = new sql.Connection(dbConfig);
  var req = new sql.Request(conn);

  conn.connect(function(err){
    if(err){
      console.log(err);
    } else {
      console.log(recordset);
    }
    conn.close();
  })
}




app.listen("3000")
