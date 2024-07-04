public class Pessoa {
    public String nome;
    public String telefone;
    public String email;

    public Pessoa(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa:" +
                "nome:" + nome + '\'' +
                ", telefone:" + telefone + '\'' +
                ", email:" + email + '\'';
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }



    public void setEmail(String email) {
        this.email = email;
    }
}
