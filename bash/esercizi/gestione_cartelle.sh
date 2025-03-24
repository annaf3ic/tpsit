#L'allievo realizzi uno script che prende nel primo parametro il nome di una cartella.
#Se la cartella non esiste, la crea.
#Se la cartella esiste, chiede all'utente se la vuole cancellare.
#In caso di risposta affermativa la cancella e poi la crea nuova, altrimenti non fa niente.

if [[ -e $1 ]]; then
echo "Vuoi cancellare la cartella?"
read RISPOSTA
if [[ $RISPOSTA == "si" ]]; then
rm -r $1
mkdir $1
echo "Ho cancellato e ricreato la cartella $1"
else
echo "Non ho cancellato la cartella $1"
fi
else
mkdir $1
echo "Ora la cartella $1 esiste"
fi

ls