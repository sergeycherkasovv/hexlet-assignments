@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <div class="mx-auto p-4 py-md-5">
                <h1>${page.getPost().getName()}</h1>
            </div>

            <div class="mx-auto p-4 py-md-5">
                ${page.getPost().getBody()}
            </div>
            <!-- BEGIN -->
            <div class="d-grid gap-2 col-6 mx-auto">
                <a href="${NamedRoutes.postEdit(page.getPost().getId())}" class="btn btn-primary">Редактировать</a>
            </div>
            <!-- END -->
        </main>
    `
)
