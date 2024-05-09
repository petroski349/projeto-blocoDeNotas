# config
```
git config --global user.name "Diogo Petroski"
```
 
```
git config --global user.email "diogopetroski@gmail.com"
```

```
git config --list
```

para conectar seu GitHub a um computador novo é preciso de uma chave ssh, jogando no google "chave ssh" mostra o comando para copiar

# pastas
`ls
	mostra os arquivos que estão na pasta
`cd 'pasta'`
	entrar na pasta
# git
`git init`
	cria um repositório
`git add .`
	manda os arquivos para uma área temporária para que salve aproxima versão podendo ser também `git add 'arquivo'`
`git add -p`
	consigo escolher alteração por alteração que irão para o staging
`git status`
	mostra o se tem arquivos modificados para dar commit
`git commit -m "mensagem"`
	faz um commit gravando a mensagem
`git branch -M Main`
	garante que o nome da branch principal é main e não master
`git remote add origin git@github.com:seuusuario/seurepositorio.git`
	linka a um repositório remoto
`git remote -v`
	mostra para qual repositório remoto esta apontando
`git set-url origin ...`
	muda o repositório apontado
`git push -u origin main` ou `git push`
	push pela primeira vez
`git push -f`
	força o push, pode ser usado quando tem um histórico de commits diferente do GitHub, e você quer substituir
`git clone linkGeradoPelo GitHub na versão ssh`
	 copia para a sua máquina uma cópia do repositório  
`git log`
	mostra as versões feitas
`git log --oneline`
	mostra as versões feitas de forma resumida 
`git reset`
	retira os arquivos da área que o `add .` deixa
`git diff 'arqivo'`
	mostra o que foi alterado no arquivo
`git reset --soft HEAD~1` 
	desfazer o último commit mantendo as modificações feitas
`git reset --hard 'cod do commit'` ou `HEAD~1`
	volta o projeto a este commit e exclui as alterações posteriores
`git pull 'repositório remoto' branch`
	trás do GitHub para a branch
## checkout
`git checkout 'código do commit'` 
	volta o projeto para  a versão do código que foi inserido 
`git checkout main`
	volta para a ultima versão daquela branch (HEAD)
`git checkout HEAD~1`
	retorna para versão anterior o HEAD o número de vezes que foi pedido no ~numero
#### quando fizer checkout para uma versão antiga não posso modificar nenhum arquivo	
se fizer acidentalmente :
```
git reset
git clean -df
git checkout -- .
```
assim eu volto para o estado do ultimo commit
# Limpar a tela
`clear`
# .gitignore
`*.dat` extensão 
`node_modules/` diretório

# VS Code
`code .`
	abre o vs code na quela pasta