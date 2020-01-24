# DataMiningFile

Se citeste un fisier de tip txt si se creeaza pe baza acestuia un fisier de tip arff. Exemplu:

Fisier txt:

paine, lapte    
paine, scutece, oua, bere     
lapte, scutece, bere, carne     
paine, lapte, oua    
paine, lapte, scutece, bere   
lapte, scutece, bere   

Fisier arff:

@attribute 'paine' { t}    
@attribute 'lapte' { t}     
@attribute 'scutece' { t}   
@attribute 'oua' { t}   
@attribute 'bere' { t}    
@attribute 'carne' { t}    
@data     
t, t, ?, ?, ?, ?,      
t, ?, t, t, t, ?,    
?, t, t, ?, t, t,    
t, t, ?, t, ?, ?,    
t, t, t, ?, t, ?,     
?, t, t, ?, t, ?,    

