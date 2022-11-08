<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="pt-br">
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Cadastrar Funcionario</title>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
      <meta name="theme-color" content="#712cf9">
    </head>
  <body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>Cadastrar Funcionario</h2>
    </div>
    <div class="row g-5">
      <div class="col-md-7 col-lg-8">
        <h4 class="mb-3">Dados</h4>
        <form class="needs-validation" novalidate>
          <div class="row g-3">
            <div class="col-12">
              <label for="nome" class="form-label">Nome</label>
              <input type="text" name="nome" class="form-control" id="nome" placeholder="" value="" required>
              <div class="invalid-feedback">
                Nome é obrigatório
              </div>
            </div>

            <div class="col-sm-8">
              <label for="cpf" class="form-label">CPF</label>
                <input type="text" name="cpf" class="form-control" id="cpf" placeholder="CPF" required>
                <div class="invalid-feedback">
                CPF é obrigatório
                </div>
                <label for="nascimento" class="form-label">Data Nascimento</label>
                  <input type="date" name="data" class="form-control" id="nascimento" required>
                  <div class="invalid-feedback">
                    Data é obrigatória
                  </div>
              </div>
            
            <div class="col-12">
                <label for="email" class="form-label">Email</label>
                <input type="email" name="email" class="form-control" id="email" placeholder="you@example.com" required>
                <div class="invalid-feedback">
                    Email é obrigatório
                </div>
            </div>

            <div class="col-12">
              <label for="endereco" class="form-label">Endereço</label>
              <input type="text" name="endereco" class="form-control" id="endereco" placeholder="Rua... Nº Bairro..." required>
              <div class="invalid-feedback">
               Endereço é obrigatório
              </div>
            </div>

            <div class="col-sm-8">
              <label for="telefone" class="form-label">Telefone</label>
              <input type="text" name="telefone" class="form-control" id="telefone" placeholder="(DDD)9XXXX-XXXX" required>
              <div class="invalid-feedback">
                Telefone é obrigatório
              </div>
            </div>

          </div>
          <hr class="my-4">

          <h4 class="mb-3">Pagamento</h4>

          <div class="row gy-3">
            <div class="col-md-6">
              <label for="jornada" class="form-label">Jornada</label>
              <input type="text" name="jornada" class="form-control" id="jornada" placeholder="" required>
              <div class="invalid-feedback">
                Jornada é obrigatório
              </div>
            </div>

            <div class="col-md-6">
              <label for="phora" class="form-label">Pagamento p/hora</label>
              <input type="text" name="pagamento" class="form-control" id="phora" placeholder="" required>
              <div class="invalid-feedback">
                P/Hora é obrigatório
              </div>
            </div>
          <hr class="my-4">

          <button class="w-100 btn btn-primary btn-lg" style="margin-bottom: 20px;" type="submit">Cadastrar</button>
        </form>
      </div>
    </div>
  </main>
</div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
    <script src="form-validation.js"></script>
  </body>
</html>
