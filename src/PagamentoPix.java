//Implementa o contrato para a lógica de PIX.
public class PagamentoPix implements ProcessadorPagamento{
    private boolean pagamentoConfirmado = false;
    @Override
    public String iniciarPagamento(Pedido pedido) {
        System.out.println("Processando PIX para o pedido " + pedido.getId() + " no valor de R$ " + pedido.getValorTotal());
        System.out.println("QRCode gerado: (simulando código PIX copia-e-cola)");
        System.out.println("Aguardando pagamento pelo cliente...");

        //Simulaçãi: 50% de chance do cliente pagar na hira.
        if (Math.random() > 0.5) {
            this.pagamentoConfirmado = true;
        }

        return "PIX_ " + new java.util.Random().nextInt(1000);
    }

    @Override
    public StatusPagamento verificarStatus(String idTransacao) {
        System.out.println("Consultando Banco Central para o PIX: " + idTransacao);
        //Simule que a confirmação chegou.
        if (this.pagamentoConfirmado) {
            return StatusPagamento.APROVADO;
        }
        return StatusPagamento.PENDENTE;
    }
}