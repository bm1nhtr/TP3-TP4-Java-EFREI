# Workflow de Collaboration

## Table des matières

1. [Contexte et problème](#1-contexte-et-problème)
2. [Solution : Workflow séquentiel](#2-solution--workflow-séquentiel)
3. [Règle critique : Vérifier votre branche](#3-règle-critique--vérifier-votre-branche)
4. [Structure du projet en 2 parties](#4-structure-du-projet-en-2-parties)
5. [Commandes Git détaillées](#5-commandes-git-détaillées)
6. [Comment merger une branche dans develop](#6-comment-merger-une-branche-dans-develop)
7. [Notes importantes et bonnes pratiques](#7-notes-importantes-et-bonnes-pratiques)

---

## 1. Contexte et problème

### Contexte

J'ai déjà merge la branche `develop` une première fois, et je suis certain qu'il y aura des conflits sur certaines classes que nous avons codées tous les deux.

Pour éviter tout impact ou écrasement de code, voici le workflow que je propose.

### Problème à éviter

Parfois, A et B ont besoin d'une même fonction de base pour avancer, donc chacun code sa propre version. Au moment de merge : **conflit**.

---

## 2. Solution : Workflow séquentiel

### 2.1. Étape 1 : Première Pull Request

1. **A** ouvre sa Pull Request en premier (dans ce cas, c'est moi, car j'ai merge la PR quand `develop` était encore vide → pas de conflit).
2. **B** fait la review, et discute avec **A** si nécessaire.
3. La PR d'**A** est mergée → version officielle dans `develop`.

### 2.2. Étape 2 : Mise à jour de la branche de B

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

### 2.3. Résultat

Ainsi, on obtient une version standardisée dans `develop`.

### 2.4. Notes importantes sur le workflow

- **Note :** Ce workflow se répète pour chaque nouvelle modification (partie 1, partie 2, etc.).
- **Note importante :** Les rôles A et B seront inversés si vous mergez en premier. Dans ce cas, vous deviendrez A (celui qui merge en premier) et je deviendrai B (celui qui doit mettre à jour sa branche après).
- **Rappel important :** À partir de la deuxième fois, vous devez vous assurer que votre version locale correspond à la version distante (remote), c'est-à-dire la version la plus récente de la branche que vous souhaitez modifier. Toujours faire `git fetch` et `git pull` avant de commencer à travailler.

---

## 3. Règle critique : Vérifier votre branche

### 3.1. Pourquoi c'est important

**IMPORTANT :** Avant de faire **QUOI QUE CE SOIT**, vous devez absolument vous assurer d'être sur la **bonne branche** (votre branche personnelle, pas `develop` ou `main`).

### 3.2. Workflow de synchronisation avec `develop`

1. **Vérifier sur quelle branche vous êtes actuellement :**
   ```bash
   git branch
   # ou
   git status
   ```
   La branche actuelle sera marquée d'un astérisque (*) ou indiquée dans le statut.

2. **Si vous n'êtes pas sur votre branche personnelle, basculez dessus :**
   ```bash
   git checkout dev_maroaune  # ou le nom de votre branche
   ```

3. **Récupérer le code standardisé depuis `develop` :**
   ```bash
   git pull origin develop
   ```
   Cette commande récupère les modifications de `develop` et les merge dans votre branche personnelle.

4. **Résoudre les conflits si nécessaire :**
   - Si Git signale des conflits, résolvez-les manuellement
   - Puis faites : `git add .` et `git commit -m "Résolution des conflits"`

5. **Travailler sur votre branche personnelle :**
   - Faites vos modifications
   - Committez vos changements : `git add .` puis `git commit -m "Description"`

6. **Une fois votre code complet et testé sur votre branche personnelle :**
   ```bash
   git push origin dev_maroaune  # Poussez votre branche personnelle
   ```
   Ensuite, ouvrez une Pull Request pour merger dans `develop`.

### 3.3. Ce qu'il ne faut JAMAIS faire

**⚠️ NE JAMAIS :**
- Travailler directement sur `develop` ou `main`
- Push directement sur `develop` sans passer par une Pull Request
- Oublier de vérifier votre branche avant de commencer à coder

---

## 4. Structure du projet en 2 parties

### 4.1. Vue d'ensemble

Cette branche `develop` sera divisée en deux parties (autrement dit, sera standardisée 2 fois) :

### 4.2. Partie 1 : Création des classes

- Création des classes
- Test sur `main.java`

**Note :** Maintenant, je t'attends pour qu'on finisse la partie 1.

### 4.3. Partie 2 : Création des méthodes

- Création des méthodes
- Test sur `main.java`

### 4.4. Options pour travailler sur les parties

#### Option 1 : Réutiliser la même branche (recommandé)

- Vous pouvez continuer à travailler sur votre branche existante (`dev_maroaune` par exemple)
- Mettez-la à jour avec `develop` : `git rebase origin/develop` ou `git merge origin/develop`
- Résolvez les conflits si nécessaire
- Continuez à travailler et ouvrez une nouvelle PR

#### Option 2 : Créer une nouvelle branche

- Pour la partie 2, on crée de nouvelles branches (`dev-prenom2`) à partir de `develop`, puis on merge de nouveau dans `develop`
- Créez une nouvelle branche à partir de `develop` : `git checkout -b dev-prenom2`
- Travaillez sur cette nouvelle branche
- Ouvrez une PR pour merger dans `develop`

**Note :** Les deux approches sont valides. L'option 1 (réutiliser la branche) est généralement plus simple et évite de multiplier les branches. L'option 2 peut être utile si vous voulez garder un historique séparé pour chaque partie du projet.

### 4.5. Workflow final

Quand tout est validé :
- On merge `develop` → `main` pour avoir la version finale à soumettre.

---

## 5. Commandes Git détaillées

### 5.1. Option 1 : Réutiliser la même branche (recommandé)

```bash
# 1. Vérifier sur quelle branche vous êtes
git branch
# ou
git status

# 2. Basculer sur votre branche personnelle si nécessaire
git checkout dev_maroaune  # ou votre branche existante

# 3. Récupérer le code standardisé depuis develop
git pull origin develop

# 4. Résoudre les conflits si nécessaire
# (éditer les fichiers en conflit, puis :)
git add .
git commit -m "Résolution des conflits"

# 5. Travailler sur votre branche
# (faire vos modifications, puis :)
git add .
git commit -m "Description des modifications"

# 6. Pousser votre branche personnelle
git push origin dev_maroaune

# 7. Ouvrir une Pull Request pour merger dans develop
```

### 5.2. Option 2 : Créer une nouvelle branche

```bash
# 1. Vérifier que vous êtes sur develop (ou votre branche de base)
git branch

# 2. Mettre à jour develop
git checkout develop
git pull origin develop

# 3. Créer une nouvelle branche à partir de develop
git checkout -b dev-prenom2

# 4. Travailler sur votre nouvelle branche
# (faire vos modifications, puis :)
git add .
git commit -m "Description des modifications"

# 5. Pousser votre nouvelle branche
git push origin dev-prenom2

# 6. Ouvrir une Pull Request pour merger dans develop
```

---

## 6. Comment merger une branche dans develop

### 6.1. Pourquoi utiliser la ligne de commande

**Important :** Merger via le site web (GitHub/GitLab) peut parfois merger directement dans la branche main. Pour plus de contrôle, utilisez la ligne de commande.

### 6.2. Étapes pour merger une branche dans `develop`

1. **S'assurer que vous êtes à jour avec le remote :**
   ```bash
   git fetch origin
   ```

2. **Basculer sur la branche `develop` et la mettre à jour :**
   ```bash
   git checkout develop
   git pull origin develop
   ```

3. **Merger la branche de fonctionnalité dans `develop` :**
   ```bash
   git merge dev_minh  # ou le nom de la branche à merger
   ```
   
   Si vous avez des conflits, résolvez-les puis :
   ```bash
   git add .
   git commit -m "Merge dev_minh into develop"
   ```

4. **Pousser les changements vers le remote :**
   ```bash
   git push origin develop
   ```

5. **Optionnel : Supprimer la branche de fonctionnalité (si elle n'est plus nécessaire) :**
   ```bash
   git branch -d dev_maroaune  # Supprime la branche locale
   git push origin --delete dev_maroaune  # Supprime la branche distante
   ```

### 6.3. Alternative : Merger avec rebase (pour un historique plus propre)

Si vous préférez un historique linéaire :
```bash
git checkout develop
git pull origin develop
git rebase dev_maroaune  # Applique les commits de dev_maroaune sur develop
git push origin develop
```

**Note :** Le rebase réécrit l'historique, donc utilisez-le seulement si vous êtes sûr de ce que vous faites.

---

## 7. Notes importantes et bonnes pratiques

### 7.1. Règles critiques

- **⚠️ TOUJOURS vérifier sur quelle branche vous êtes avant de commencer à travailler**
- **⚠️ NE JAMAIS travailler directement sur `develop` ou `main`**

### 7.2. Bonnes pratiques de synchronisation

- Toujours utiliser `git pull origin develop` pour récupérer le code standardisé dans votre branche personnelle
- Travailler uniquement sur votre branche personnelle, puis ouvrir une Pull Request pour merger dans `develop`

### 7.3. Bonnes pratiques de collaboration

- Toujours faire une review avant de merger
- Communiquer en cas de doute sur les conflits
- Utiliser `--force-with-lease` plutôt que `--force` pour plus de sécurité
- Préférer merger via la ligne de commande pour plus de contrôle

---

Minh : "Vous pouvez ajouter des instructions pour moi ici si nécessaire"
