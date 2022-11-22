package academiawb.model.dto;

public class FinanceiroDTO {
    private Integer faturamento, receita, pagamentos;

    public FinanceiroDTO(Integer faturamento, Integer receita, Integer pagamentos) {
        this.faturamento = faturamento;
        this.receita = receita;
        this.pagamentos = pagamentos;
    }

    public Integer getFaturamento() {
        return faturamento;
    }

    public void setFaturamento(Integer faturamento) {
        this.faturamento = faturamento;
    }

    public Integer getReceita() {
        return receita;
    }

    public void setReceita(Integer receita) {
        this.receita = receita;
    }

    public Integer getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(Integer pagamentos) {
        this.pagamentos = pagamentos;
    }

    

}
