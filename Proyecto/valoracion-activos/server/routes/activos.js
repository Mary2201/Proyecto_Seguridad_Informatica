const express = require('express');
const router = express.Router();
const activosController = require('../controllers/activosController');
const { authMiddleware, adminMiddleware } = require('../middlewares/authMiddleware');

router.post('/', authMiddleware, activosController.createActivo);
router.get('/', authMiddleware, activosController.getAllActivos);
router.get('/report', authMiddleware, activosController.getReport);

module.exports = router;
