var express = require("express");
var app = express();
var sql = require('mssql')

var dbConfig = {
  server: "finit2018.c5zrm3lns2vy.us-west-2.rds.amazonaws.com",
  database:"",
  user: "findIt",
  password:"cs43652018",
  port: 1443
};



function getUser() {
  var conn = new sql.Connection(dbConfig);
  var req = new sql.Request(conn);

  conn.connect(function(err){
    if(err){
      console.log(err);
      return;
    }
    req.query("SELECT * FROM emp", function (err, recordset){
      if(err){
        console.log(err);
      }
      else {
        console.log(recordset);
      }
      conn.close();
    });
  });
}




app.listen("3000")
