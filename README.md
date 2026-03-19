Simulation SMA - Java Swing

Description : 
Ce projet est une simulation de système multi-agents (SMA) développée en Java avec Swing.

Des agents autonomes se déplacent dans un environnement contenant :
  - des obstacles
  - des lieux d’intérêt
  - d’autres agents

Les agents utilisent l’algorithme A pour se déplacer vers une destination tout en évitant les obstacles.
Selon le scénario choisi, ils peuvent également interagir entre eux (ex : propagation de maladie).


Fonctionnalités

- Interface graphique avec Java Swing
- Menu de démarrage** avec choix de scénario
- Simulation visuelle avec carte en image
- Déplacement d’agents avec algorithme A
- Obstacles et lieux générés aléatoirement
- Propagation de maladie entre agents
- Agents exécutés avec threads


Scénarios disponibles

1. Déplacement simple
   Les agents se déplacent vers des lieux aléatoires.

2. Propagation de maladie
   Un agent est initialement malade et peut contaminer les autres.

3. Propagation de rumeur
   Simulation d’interaction sociale entre agents.


Structure du projet

```
src
│
├── affichage
│   ├── MenuFrame.java
│   ├── SimulationFrame.java
│   └── SimulationPanel.java
│
├── logique
│   ├── Agent.java
│   ├── Environnement.java
│   ├── AStar.java
│   ├── Node.java
│   └── Point2D.java
```

affichage : interface graphique Swing
logique : logique de simulation et algorithmes

Projet réalisé dans le cadre d’un exercice de simulation de systèmes multi-agents.
