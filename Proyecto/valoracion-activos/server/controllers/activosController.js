const Activo = require('../models/Activo');

exports.createActivo = async (req, res) => {
    const { tipo, descripcion, categoria, valoracion, riesgo, impacto } = req.body;
    const nuevoRiesgo = calcularRiesgo(valoracion, riesgo, impacto);
    const activo = new Activo({ tipo, descripcion, categoria, valoracion, riesgo: nuevoRiesgo, impacto });
    try {
        await activo.save();
        res.status(201).send(activo);
    } catch (error) {
        res.status(400).send(error);
    }
};

exports.getAllActivos = async (req, res) => {
    try {
        const activos = await Activo.find();
        res.status(200).send(activos);
    } catch (error) {
        res.status(500).send(error);
    }
};

exports.getReport = async (req, res) => {
    try {
        const report = await Activo.aggregate([
            {
                $group: {
                    _id: '$categoria',
                    count: { $sum: 1 },
                    avgValoracion: { $avg: '$valoracion' }
                }
            }
        ]);
        res.status(200).send(report);
    } catch (error) {
        res.status(500).send(error);
    }
};

function calcularRiesgo(valoracion, riesgo, impacto) {
    // Aquí se puede implementar una fórmula más compleja
    return valoracion * riesgo * impacto;
}