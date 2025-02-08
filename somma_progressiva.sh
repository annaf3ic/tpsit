somma=0

while true; do
  echo "Inserisci un numero positivo (oppure un numero negativo per fermarti):"
  read numero

  if [[ $numero -lt 0 ]]; then
    break
  fi

  somma=$((somma + numero))
done

echo "La somma di tutti i numeri inseriti è: $somma"
