@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
    content = @`
          @if(page.getErrors() != null)
              <ul>
                  @for(var validator : page.getErrors().values())
                      @for(var error : validator)
                          <li>${error.getMessage()}</li>
                      @endfor
                  @endfor
              </ul>
          @endif
            <div class="container mt-5"> <!-- Контейнер с верхним отступом -->
                <div class="row justify-content-center"> <!-- Центрирование по горизонтали -->
                    <div class="col-md-6 col-lg-5 p-4 shadow rounded bg-light"> <!-- Размер + стили -->
                        <form action="/articles" method="post">
                            <div class="mb-3">
                                <label for="title" class="form-label">Название статьи:</label>
                                <input type="text" name="title" class="form-control" value="${page.getTitle()}">
                            </div>
                            <div class="mb-3">
                                <label for="content" class="form-label">Текст статьи:</label>
                                <textarea name="content" class="form-control" style="height: 400px">${page.getContent()}</textarea>
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary w-100">Опубликовать</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
    `
)