echo "==   uguale stringhe"
echo "!=   diverso stringhe"
echo "-z   (se) la stringa è vuota"
echo "-n   (se) la stringa non è vuota"
echo ""
echo "-eq  uguale (equals)"
echo "-ne  diverso (not equals)"
echo "-gt  maggiore (greater than)"
echo "-lt  minore (less than)"
echo "-ge  maggiore o uguale (greater or equals than)"
echo "-le  minore o uguale (less or equals than)"
echo ""
echo "-e   (se) esiste il file (exists)"
echo "-d   (se) è una directory"
echo "-f   (se) è un file"
echo "-s   (se) la dimensione è maggiore di 0"
echo "-r   (se) il file è readable"
echo "-w   (se) il file è writable"
echo "-x   (se) il file è executable"
echo "-nt  (se) il primo file è più recente del secondo (newer than)"
echo "-ot  (se) il primo file è meno recente del secondo (older than)"
echo "-et  (se) i due file sono lo stesso file (equal)"


if [[ $1 -lt 18 ]]; then
  echo "Sei minorenne"
else
  if [[ -n $2 ]]; then
	echo "Ciao $2, sei il benvenuto"
  else
	echo "Ciao ospite, sei il benvenuto"
  fi
fi
