require kubernetes.inc

PV = "1.15.2+git${SRCREV_kubernetes}"
SRCREV_kubernetes = "f6278300bebbb750328ac16ee6dd3aa7d3549568"
SRC_BRANCH = "release-1.15"

do_compile_prepend() {
    unset GOCACHE
}
