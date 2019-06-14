<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- DEPENDENCES CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">

    <title>GDT - Se connecter</title>
</head>

<body>
    <main class="p-1 text-dark">
        <div class="container">
            <div class="text-center m-5">
                <h1 class="text-success mb-3" id="logoBig">G.T.</h1>
                <h2>GDT</h2>
                <h5>Gestion du Transport</h5>
            </div>
            <form method="POST" action="http://localhost:8080/gestion-transports/login" class="container shadow p-4 bg-light" style="max-width: 500px;">
                <div class="form-group row container">
                    <label for="inputEmail" class="col-4 text-right m-0 p-2">Email</label>
                    <input name="inputEmail" type="email" class="form-control col-8" id="inputEmail">
                </div>
                <div class="form-group row container">
                    <label for="inputPassword" class="col-4 text-right m-0 p-2">Mot de passe</label>
                    <input name="inputPassword" type="password" class="form-control col-8" id="inputPassword">
                </div>
                <div class="text-right mt-5">
                    <button type="submit" class="btn btn-dark">Se connecter</button>
                </div>
            </form>
        </div>
    </main>

    <!-- SCRIPTS JS -->
    <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous">
    </script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>
</body>

</html>