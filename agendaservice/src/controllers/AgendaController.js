'use strict';

const express = require('express');
const router = express.Router();

var agendasService = require('../persistence/AgendaService');

router.get('/', async function (req, res) {
 let agendas = await agendasService.agendas;
 res.writeHead(200, {'Content-Type': 'application/json'});
 res.end(JSON.stringify(agendas));
});

router.post('/', async function (req, res) {
 var mess = {
  mensagem: ''
 };
 try {
  await agendasService.addAgenda(req.body.descricao);
  res.redirect('/agendas/');
  return;
 } catch (e) {
  mess.mensagem = `ERRO ${e}`;
 }
 res.send(mess);
});
module.exports = router;