# Utilise un serveur web léger (Nginx) pour héberger le site
FROM nginx:alpine

# Copie tes fichiers HTML et CSS dans le dossier du serveur
COPY . /usr/share/nginx/html

# Expose le port 80 pour voir le site
EXPOSE 80