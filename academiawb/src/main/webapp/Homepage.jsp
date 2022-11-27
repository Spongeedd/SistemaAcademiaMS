<%@page import="academiawb.model.db.DBConnector"%>
<%@page import="academiawb.model.service.FuncionariosService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  


<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.104.2">
    <title>Academia Homepage</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.2/examples/album/">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    
    <meta name="theme-color" content="#712cf9">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .b-example-divider {
        height: 3rem;
        background-color: rgba(0, 0, 0, .1);
        border: solid rgba(0, 0, 0, .15);
        border-width: 1px 0;
        box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
      }

      .b-example-vr {
        flex-shrink: 0;
        width: 1.5rem;
        height: 100vh;
      }

      .bi {
        vertical-align: -.125em;
        fill: currentColor;
      }

      .nav-scroller {
        position: relative;
        z-index: 2;
        height: 2.75rem;
        overflow-y: hidden;
      }

      .nav-scroller .nav {
        display: flex;
        flex-wrap: nowrap;
        padding-bottom: 1rem;
        margin-top: -1px;
        overflow-x: auto;
        text-align: center;
        white-space: nowrap;
        -webkit-overflow-scrolling: touch;
      }
    </style>   
  </head>
  <body>   
    <header>
      <div class="container">
          <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
            <a href="" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-dark text-decoration-none">
              <img class="bi me-2" src="icone.png" width="50px" height="50px" alt="">
              <strong><h3>Academia Elite Fit</h3></strong>
            </a>
      
            <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
              <li><a href="#preco" class="nav-link px-2 link-dark">Preços</a></li>
              <li><a href="https://github.com/Spongeedd/SistemaAcademiaMS" target="_blank" class="nav-link px-2 link-dark">Sobre nós</a></li>
            </ul>
      
            <div class="col-md-3 text-end">
              <a href="inicio.html" class="btn btn-outline-primary me-2" role="button" aria-disabled="true">Login funcionário</a>
              <a href="login.html" class="btn btn-primary" role="button" aria-disabled="true">Login aluno</a>
            </div>
          </header>
        </div>
    </header>
    <main>
    <section class="py-5 text-center container">
        <div class="row py-lg-5">
        <div class="col-lg-6 col-md-8 mx-auto">
            <h1 class="fw-light">Academia Elite Fit</h1>
            <p class="lead text-muted">Um lugar onde você pode se sentir à vontade para conseguir o sorpo dos seus sonhos.</p>
        </div>
        </div>
    </section>

    <div class="album py-5 bg-light">
        <div class="container">
        <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://www.proteste.org.br/-/media/proteste/images/home/sa%C3%BAde%20e%20bem%20estar/como-escolher-academia.jpg?rev=b65914a8-f917-4945-a5ab-5f10bee78712" alt="">
                <div class="card-body">
                <p class="card-text">Variedade de aparelhos.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://www.blog.nadarte.com/wp-content/uploads/2020/09/post_thumbnail-7aa5da8f19c9a0b0b0998194811ca5aa-1160x770.jpeg" alt="">
                <div class="card-body">
                <p class="card-text">Uso compartilhado.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://s.zst.com.br/cms-assets/2021/09/roupa-de-academia-feminina-2-.png" alt="">
                <div class="card-body">
                <p class="card-text">Diversidade de exercícios.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://img.freepik.com/fotos-gratis/homem-forte-treinando-na-academia_1303-23478.jpg?w=2000" alt="">
                <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://img.elo7.com.br/product/main/1CC37D3/quadro-decorativo-fitness-academia-decoracao-com-moldura-008-quadro-quartos.jpg" alt="">
                <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://veja.abril.com.br/wp-content/uploads/2016/07/saude-academia-20160726-05.jpg" alt="">
                <div class="card-body">
                <p class="card-text"></p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://d1a3v8txm37nbo.cloudfront.net/image/partners/482508/md_d94c1a42-f70f-4573-ad99-335b8dec2f75_aaadceaaebbdWhatsAppImageat...jpeg" alt="">
                <div class="card-body">
                <p class="card-text">Espaço amplo.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://www.fecomercio.com.br/upload/img/2017/04/18/58f60e8c80d6b-noticia_hotel_com_academia_atrai_mais_h_spedes_corporativos.jpg" alt="">
                <div class="card-body">
                <p class="card-text">Equipamento de qualidade.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>

            <div class="col">
            <div class="card shadow-sm">
                <img class="bd-placeholder-img card-img-top" width="100%" height="225" src="https://boaforma.abril.com.br/wp-content/uploads/sites/2/2017/01/thinkstockphotos-530414728.jpg" alt="">
                <div class="card-body">
                <p class="card-text">Treinos em grupo.</p>
                <div class="d-flex justify-content-between align-items-center">
                    <small class="text-muted"></small>
                </div>
                </div>
            </div>
            </div>
        </div>
        </div>
    </div>

    <div class="container py-3">
  
          <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
            <h1 class="display-4 fw-normal">Planos</h1>
            <p class="fs-5 text-muted">Um comparativo entre os preços dos planos e as vantagens de cada um.</p>
          </div>
        <main>
          <div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
            <div class="col">
              <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                  <h4 class="my-0 fw-normal">Básico</h4>
                </div>
                <div class="card-body">
                  <h1 class="card-title pricing-card-title">R$ 30<small class="text-muted fw-light">,00</small></h1>
                  <ul class="list-unstyled mt-3 mb-4">
                    <li>Acesso à academia</li>
                    <li>Horário fixo</li>
                    <li>Treino fixo</li>
                  </ul>
                  <button type="button" class="w-100 btn btn-lg btn-outline-primary">Entre em contato</button>
                </div>
              </div>
            </div>
            <div class="col">
              <div class="card mb-4 rounded-3 shadow-sm">
                <div class="card-header py-3">
                  <h4 class="my-0 fw-normal">Intermediário</h4>
                </div>
                <div class="card-body">
                  <h1 class="card-title pricing-card-title">R$ 55<small class="text-muted fw-light">,00</small></h1>
                  <ul class="list-unstyled mt-3 mb-4">
                    <li>Acesso à academia</li>
                    <li>Horário livre</li>
                    <li>Acesso a todas as unidades</li>
                    <li>Adesão grátis</li>
                    <li>Montagem de treino</li>
                  </ul>
                  <button type="button" class="w-100 btn btn-lg btn-primary">Entre em contato</button>
                </div>
              </div>
            </div>
            <div class="col">
              <div class="card mb-4 rounded-3 shadow-sm border-primary">
                <div class="card-header py-3 text-bg-primary border-primary">
                  <h4 class="my-0 fw-normal">Premium</h4>
                </div>
                <div class="card-body">
                  <h1 class="card-title pricing-card-title">R$ 100<small class="text-muted fw-light">,00</small></h1>
                  <ul class="list-unstyled mt-3 mb-4">
                    <li>Acesso à academia</li>
                    <li>Horário livre</li>
                    <li>Acesso a todas as unidades</li>
                    <li>Adesão grátis</li>
                    <li>Montagem de treino</li>
                    <li>Acesso a personal trainer</li>
                  </ul>
                  <button type="button" class="w-100 btn btn-lg btn-primary">Entre em contato</button>
                </div>
              </div>
            </div>
          </div>
      
          <h2 class="display-6 text-center mb-4">Comparativo dos planos</h2>
      
          <div class="table-responsive">
            <table class="table text-center">
              <thead>
                <tr>
                  <th style="width: 34%;"></th>
                  <th style="width: 22%;">Básico</th>
                  <th style="width: 22%;">Intermediário</th>
                  <th style="width: 22%;">Premium</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th scope="row" class="text-start">Acesso à academia</th>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
                <tr>
                  <th scope="row" class="text-start">Horário livre</th>
                  <td></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
              </tbody>
      
              <tbody>
                <tr>
                  <th scope="row" class="text-start">Montagem de treino</th>
                  <td><svg class="bi" width="24" height="24"><use xlink:href="#check"/></svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
                <tr>
                  <th scope="row" class="text-start">Acesso a todas as unidades</th>
                  <td></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
                <tr>
                  <th scope="row" class="text-start">Adesão grátis</th>
                  <td></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
                <tr>
                  <th scope="row" class="text-start">Acesso a personal trainer</th>
                  <td></td>
                  <td></td>
                  <td><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check-lg" viewBox="0 0 16 16">
                    <path d="M12.736 3.97a.733.733 0 0 1 1.047 0c.286.289.29.756.01 1.05L7.88 12.01a.733.733 0 0 1-1.065.02L3.217 8.384a.757.757 0 0 1 0-1.06.733.733 0 0 1 1.047 0l3.052 3.093 5.4-6.425a.247.247 0 0 1 .02-.022Z"/>
                  </svg></td>
                </tr>
              </tbody>
            </table>
          </div>
        </main>
      
        <footer class="pt-4 my-md-5 pt-md-5 border-top">
          <div class="row">
          </div>
        </footer>
      </div>
    </main>

    <footer class="text-muted py-5">
    <div class="container">
        <p class="float-end mb-1">
        <a href="#">Voltar ao topo</a>
        </p>
    </div>
    </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>
  </body>
</html>
