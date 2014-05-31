(ns leiningen.new.om
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files
                                             year]]
            [leiningen.core.main :as main]))

(def render (renderer "om"))

(defn om
  "Om project boilerplate"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year (year)}]
    (main/info "Generating fresh 'lein new' om project.")
    (->files data
             ["LICENSE" (render "LICENSE")]
             ["README.md" (render "README.md" data)]
             ["index.html" (render "index.html" data)]
             ["project.clj" (render "project.clj" data)]

             ["src/clj/{{sanitized}}/core.clj" (render "core.clj" data)]
             ["src/cljs/{{sanitized}}/core.cljs" (render "core.cljs" data)]
             ["src/cljs/{{sanitized}}/navigation.cljs" (render "navigation.cljs" data)]

             ["observr/less.observr" (render "observr/less.observr")]

             ["resources/less/bootstrap/alerts.less" (render "resources/less/bootstrap/alerts.less")]
             ["resources/less/bootstrap/badges.less" (render "resources/less/bootstrap/badges.less")]
             ["resources/less/bootstrap/bootstrap.less" (render "resources/less/bootstrap/bootstrap.less")]
             ["resources/less/bootstrap/breadcrumbs.less" (render "resources/less/bootstrap/breadcrumbs.less")]
             ["resources/less/bootstrap/button-groups.less" (render "resources/less/bootstrap/button-groups.less")]
             ["resources/less/bootstrap/buttons.less" (render "resources/less/bootstrap/buttons.less")]
             ["resources/less/bootstrap/carousel.less" (render "resources/less/bootstrap/carousel.less")]
             ["resources/less/bootstrap/close.less" (render "resources/less/bootstrap/close.less")]
             ["resources/less/bootstrap/code.less" (render "resources/less/bootstrap/code.less")]
             ["resources/less/bootstrap/component-animations.less" (render "resources/less/bootstrap/component-animations.less")]
             ["resources/less/bootstrap/dropdowns.less" (render "resources/less/bootstrap/dropdowns.less")]
             ["resources/less/bootstrap/forms.less" (render "resources/less/bootstrap/forms.less")]
             ["resources/less/bootstrap/glyphicons.less" (render "resources/less/bootstrap/glyphicons.less")]
             ["resources/less/bootstrap/grid.less" (render "resources/less/bootstrap/grid.less")]
             ["resources/less/bootstrap/input-groups.less" (render "resources/less/bootstrap/input-groups.less")]
             ["resources/less/bootstrap/jumbotron.less" (render "resources/less/bootstrap/jumbotron.less")]
             ["resources/less/bootstrap/labels.less" (render "resources/less/bootstrap/labels.less")]
             ["resources/less/bootstrap/list-group.less" (render "resources/less/bootstrap/list-group.less")]
             ["resources/less/bootstrap/media.less" (render "resources/less/bootstrap/media.less")]
             ["resources/less/bootstrap/mixins.less" (render "resources/less/bootstrap/mixins.less")]
             ["resources/less/bootstrap/modals.less" (render "resources/less/bootstrap/modals.less")]
             ["resources/less/bootstrap/navbar.less" (render "resources/less/bootstrap/navbar.less")]
             ["resources/less/bootstrap/navs.less" (render "resources/less/bootstrap/navs.less")]
             ["resources/less/bootstrap/normalize.less" (render "resources/less/bootstrap/normalize.less")]
             ["resources/less/bootstrap/pager.less" (render "resources/less/bootstrap/pager.less")]
             ["resources/less/bootstrap/pagination.less" (render "resources/less/bootstrap/pagination.less")]
             ["resources/less/bootstrap/panels.less" (render "resources/less/bootstrap/panels.less")]
             ["resources/less/bootstrap/popovers.less" (render "resources/less/bootstrap/popovers.less")]
             ["resources/less/bootstrap/print.less" (render "resources/less/bootstrap/print.less")]
             ["resources/less/bootstrap/progress-bars.less" (render "resources/less/bootstrap/progress-bars.less")]
             ["resources/less/bootstrap/responsive-utilities.less" (render "resources/less/bootstrap/responsive-utilities.less")]
             ["resources/less/bootstrap/scaffolding.less" (render "resources/less/bootstrap/scaffolding.less")]
             ["resources/less/bootstrap/tables.less" (render "resources/less/bootstrap/tables.less")]
             ["resources/less/bootstrap/theme.less" (render "resources/less/bootstrap/theme.less")]
             ["resources/less/bootstrap/thumbnails.less" (render "resources/less/bootstrap/thumbnails.less")]
             ["resources/less/bootstrap/tooltip.less" (render "resources/less/bootstrap/tooltip.less")]
             ["resources/less/bootstrap/type.less" (render "resources/less/bootstrap/type.less")]
             ["resources/less/bootstrap/utilities.less" (render "resources/less/bootstrap/utilities.less")]
             ["resources/less/bootstrap/variables.less" (render "resources/less/bootstrap/variables.less")]
             ["resources/less/bootstrap/wells.less" (render "resources/less/bootstrap/wells.less")]
             ["resources/less/styles.less" (render "resources/less/styles.less")]

             ["resources/public/fonts/glyphicons-halflings-regular.eot"
              (render "resources/public/fonts/glyphicons-halflings-regular.eot")]
             ["resources/public/fonts/glyphicons-halflings-regular.svg"
              (render "resources/public/fonts/glyphicons-halflings-regular.svg")]
             ["resources/public/fonts/glyphicons-halflings-regular.ttf"
              (render "resources/public/fonts/glyphicons-halflings-regular.ttf")]
             ["resources/public/fonts/glyphicons-halflings-regular.woff"
              (render "resources/public/fonts/glyphicons-halflings-regular.woff")]

             "doc"
             "resources/public/css"
             "resources/public/fonts"
             "resources/public/js"
             "test")))
