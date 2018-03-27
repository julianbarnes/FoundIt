var express = require("express");
var app = express();
var sql = require('mssql')

// var login_route = require('./routes/login');
// var item_browse_route = require('./routes/itembrowse');
// var submit_report_route = require('./routes/submitreport');

var dbConfig = {
  server: "finit2018.c5zrm3lns2vy.us-west-2.rds.amazonaws.com",
  database:"foundit",
  user: "findIt",
  password:"cs64432018",
  port: 1433
};

//Test route that pulls from the database

app.get('/api/Users', function(req, res) {
  var command = "SELECT * FROM admin";
  connect(command, res);//returns an array
});

app.get('/api/FoundItems', function(req, res) {
  var command = "SELECT * FROM foundReport";
  connect(command, res);
})

app.post('/api/login', function(req,res) {
  // var username = req.username;
  // var password = req.password;
  //
  // var result =
})



function connect(query, res) {
  var conn = new sql.Connection(dbConfig);
  var req = new sql.Request(conn);

  conn.connect(function(err){
    if(err){
      console.log(err);
      return;
    }
    req.query(query, function (err, recordset){
      if(err){
        console.log(err);
      }
      else {
        console.log(recordset);
        res.send(JSON.stringify(recordset[0]));
      }
      conn.close();
    });
  });
}

// app.use('/api/login', login_route);//require login controller
// app.use('/api/itembrowse', item_browse_route);//require item browse controller
// app.use('/api/submitreport', submit_report_route);



app.listen("3000")
