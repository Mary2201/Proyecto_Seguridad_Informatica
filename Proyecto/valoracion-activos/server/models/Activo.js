const mongoose = require('mongoose');

const ActivoSchema = new mongoose.Schema({
    tipo: { type: String, required: true },
    descripcion: { type: String, required: true },
    categoria: { type: String, required: true },
    valoracion: { type: Number, required: true },
    riesgo: { type: Number, required: true },
    impacto: { type: Number, required: true }
});

module.exports = mongoose.model('Activo', ActivoSchema);
