# Workflow de Collaboration

## Contexte

J'ai déjà merge la branche `develop` une première fois, et je suis certain qu'il y aura des conflits sur certaines classes que nous avons codées tous les deux.

Pour éviter tout impact ou écrasement de code, voici le workflow que je propose.

## Problème à éviter

Parfois, A et B ont besoin d'une même fonction de base pour avancer, donc chacun code sa propre version. Au moment de merge : **conflit**.

## Solution : Workflow séquentiel

### Étape 1 : Première Pull Request

1. **A** ouvre sa Pull Request en premier (dans ce cas, c'est moi, car j'ai merge la PR quand `develop` était encore vide → pas de conflit).
2. **B** fait la review, et discute avec **A** si nécessaire.
3. La PR d'**A** est mergée → version officielle dans `develop`.

### Étape 2 : Mise à jour de la branche de B

1. **B** met sa branche (`dev_maroaune`) à jour :
   ```bash
   git fetch
   git rebase origin/develop
   # ou
   git merge origin/develop
   ```
2. **B** résout les conflits avec la version officielle.
3. Quand la branche de **B** est propre et à jour :
   - **B** pousse (avec `--force-with-lease` si nécessaire après rebase) puis ouvre sa PR.
4. **A** fait la review de la PR de **B**, et discute avec **B** si nécessaire.
5. La PR de **B** est mergée → version standardisée dans `develop`.

Ainsi, on obtient une version standardisée dans `develop`.

**Note :** Ce workflow se répète pour chaque nouvelle modification (partie 1, partie 2, etc.).

**Note importante :** Les rôles A et B seront inversés si vous mergez en premier. Dans ce cas, vous deviendrez A (celui qui merge en premier) et je deviendrai B (celui qui doit mettre à jour sa branche après).

**Rappel important :** À partir de la deuxième fois, vous devez vous assurer que votre version locale correspond à la version distante (remote), c'est-à-dire la version la plus récente de la branche que vous souhaitez modifier. Toujours faire `git fetch` et `git pull` avant de commencer à travailler.

## Structure du projet en 2 parties

Cette branche `develop` sera divisée en deux parties (autrement dit, sera standardisée 2 fois) :

### Partie 1 : Création des classes (Maintenant, je t'attends pour qu'on fini la 1 partie.)
- Création des classes
- Test sur `main.java`

### Partie 2 : Création des méthodes
- Création des méthodes
- Test sur `main.java`

**Option 1 : Réutiliser la même branche (recommandé)**
- Vous pouvez continuer à travailler sur votre branche existante (`dev_maroaune` par exemple)
- Mettez-la à jour avec `develop` : `git rebase origin/develop` ou `git merge origin/develop`
- Résolvez les conflits si nécessaire
- Continuez à travailler et ouvrez une nouvelle PR

**Option 2 : Créer une nouvelle branche**
- Pour la partie 2, on crée de nouvelles branches (`dev-prenom2`) à partir de `develop`, puis on merge de nouveau dans `develop`
- Créez une nouvelle branche à partir de `develop` : `git checkout -b dev-prenom2`
- Travaillez sur cette nouvelle branche
- Ouvrez une PR pour merger dans `develop`

**Note :** Les deux approches sont valides. L'option 1 (réutiliser la branche) est généralement plus simple et évite de multiplier les branches. L'option 2 peut être utile si vous voulez garder un historique séparé pour chaque partie du projet.

## Workflow final

Quand tout est validé :
- On merge `develop` → `main` pour avoir la version finale à soumettre.


## Résumé des commandes Git

### Option 1 : Réutiliser la même branche (recommandé)

```bash
# Mise à jour de la branche locale existante
git fetch origin
git checkout dev_maroaune  # ou votre branche existante
git rebase origin/develop
# Résoudre les conflits si nécessaire
git push --force-with-lease origin dev_maroaune
# Continuer à travailler et ouvrir une nouvelle PR
```

### Option 2 : Créer une nouvelle branche

```bash
# Créer une nouvelle branche pour la partie 2
git checkout develop
git pull origin develop
git checkout -b dev-prenom2
# Faire les modifications
git add .
git commit -m "Description des modifications"
git push origin dev-prenom2
```

## Notes importantes

- Toujours faire une review avant de merger
- Communiquer en cas de doute sur les conflits
- Utiliser `--force-with-lease` plutôt que `--force` pour plus de sécurité


Minh : "Vous pouvez ajouter des instructions pour moi ici ci neccessaires"
