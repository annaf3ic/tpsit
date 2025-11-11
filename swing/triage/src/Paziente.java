public class Paziente {
    String nome;
    String cognome;
    String cf;
    String motivo;
    String id;
    String colore;
    int urgenza;

    public Paziente(String nome, String cognome, String cf, String motivo, String id, String colore) {
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.motivo = motivo;
        this.id = id;
        this.colore = colore;
        switch (colore) {
            case "ROSSO": this.urgenza = 5;
            case "GIALLO": this.urgenza = 4;
            case "AZZURRO": this.urgenza = 3;
            case "VERDE": this.urgenza = 2;
            case "BIANCO": this.urgenza = 1;
        }
        // assegna un'urgenza in formato numerico in base al colore
    }

    @Override
    public String toString() {
        return nome + " " + cognome + ", " + colore + ", " + id;
    }
}