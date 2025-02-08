#lo script riceve in parametro due numeri e stampa a video la loro somma. Se i due numeri non sono passati (entrambi o uno solo) li richiede all'utente.

if [[ -z $1 || -z $2 ]]; then
    echo "Inserisci il primo operando: "
    read a
    echo "Inserisci il secondo operando: "
    read b
else
    a=$1
    b=$2
fi


somma=$((a+b))

echo "La somma di $a e $b è $somma"