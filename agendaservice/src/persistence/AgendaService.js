class AgendasService {
 static agendas = [];
 static async addAgenda(descricao) {
  await AgendasService.agendas.push({
   'descricao': descricao
  });
 }
}

module.exports = AgendasService;