package academiawb.model.dto;

public class FinanceiroDTO {
    private Integer faturamento, receita, pagamentos;
    private Integer basico, intermediario, premimum;

    public FinanceiroDTO(Integer faturamento, Integer receita, Integer pagamentos) {
        this.faturamento = faturamento;
        this.receita = receita;
        this.pagamentos = pagamentos;
    }

    public FinanceiroDTO(Integer pagamento) {
        this.pagamentos = pagamento;
    }

    public FinanceiroDTO(Integer faturamento, Integer basico, Integer intermediario, Integer premium) {
        this.faturamento = faturamento;
        this.basico = basico;
        this. intermediario = intermediario;
        this. premimum = premium;
    }

    public FinanceiroDTO() {
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
    
    public Integer getBasico() {
        return basico;
    }

    public void setBasico(Integer basico) {
        this.basico = basico;
    }

    public Integer getIntermediario() {
        return intermediario;
    }

    public void setIntermediario(Integer intermediario) {
        this.intermediario = intermediario;
    }

    public Integer getPremimum() {
        return premimum;
    }

    public void setPremimum(Integer premimum) {
        this.premimum = premimum;
    }


}
