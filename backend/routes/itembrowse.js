var express = require('express');
var router = express.Router();
var assignmentController = require('../controllers/assignmentController');//replace with itembrowsecontroller

router.route('/lostitems')
.get();
