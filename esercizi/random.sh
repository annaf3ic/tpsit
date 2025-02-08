numero_random=$((RANDOM % 10 + 1))

max_tentativi=5

echo "Indovina il numero casuale tra 1 e 10! Hai $tentativi tentativi."

for (( i=1; i<=$max_tentativi; i++ )); do
  echo "Tentativo $i di $max_tentativi:"
  read guess

  if [[ $guess -eq $numero_random ]]; then
    echo "Congratulazioni! Hai indovinato il numero!"
    exit 0
  # parte aggiuntiva: indica se iil numero in input è maggiore o minora di quello da indovinare
  elif [[ $guess -lt $numero_random ]]; then
    echo "Il numero è più grande. Riprova."
  else
    echo "Il numero è più piccolo. Riprova."
  fi
done

echo "Purtroppo non hai indovinato il numero. Il numero era: $numero_random"